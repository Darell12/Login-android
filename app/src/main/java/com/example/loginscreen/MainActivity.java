package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.LoginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ejecuta la prueba de conexión en un hilo separado utilizando AsyncTask.
                new TestConnectionTask().execute();

            }
        });
    }

    public static void main(String[] args) {
        // Prueba la conexión a la base de datos y realiza una consulta
        MySQLConnection.testConnection();
    }

    private class TestConnectionTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            // Intenta establecer una conexión a la base de datos.
            Connection connection = MySQLConnection.getConnection();

            if (connection != null) {
                try {
                    // Cierra la conexión después de usarla.
                    connection.close();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean isConnected) {
            if (isConnected) {
                Toast.makeText(MainActivity.this, "Conexión exitosa", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Error al conectar a la base de datos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
