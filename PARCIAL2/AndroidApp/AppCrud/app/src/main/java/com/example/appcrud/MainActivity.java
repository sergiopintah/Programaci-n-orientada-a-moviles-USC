package com.example.appcrud;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.appcrud.model.Empleado;
import com.example.appcrud.sinterface.CrudEmpleadoInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Empleado> listEmpleado;
    CrudEmpleadoInterface crudempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** INSERT **/
        Empleado emple1 = new Empleado(1L,"SERGIO PINTA","123ABC","sergio@gmail.com");
        guardarEmpleado(emple1);

        Empleado emple2 = new Empleado(2L,"DANIEL ROJAS","569SSD","daniel@gmail.com");
        guardarEmpleado(emple2);

        /** SELECT **/

        getAll();

        /** UPDATE **/

        Empleado emple3 = new Empleado(1L,"DANIEL MANTILLA","569SSD","daniel@gmail.com");
        actualizarEmpleado(emple3);

        getAll();

        /** DELETE **/

        eliminarEmpleado(2l);

        getAll();
    }

    private void getAll(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = crudempleado.getAll();
        
        call.enqueue(new Callback<List<Empleado>>() {

            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response){
                if(!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e("Response error:,", response.message());
                    return;
                }
                listEmpleado = response.body();
                listEmpleado.forEach(p-> Log.i("**SELECT** Listado de empleados: ", p.toString()));
            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t){
                //System.out.println(t.getMessage());
                Log.e("Trow error: ", t.getMessage());
            }


        });
    }

    private void guardarEmpleado(Empleado empleado){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = crudempleado.guardarEmpleado(empleado);

        call.enqueue(new Callback<Empleado>() {

            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response){
                if(!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e("Response error:,", response.message());
                    return;
                }
                Empleado empleado = response.body();
                Log.e("**INSERT** Nombre empleado creado: ", empleado.getNombre());
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t){
                //System.out.println(t.getMessage());
                Log.e("Throw error: ", t.getMessage());
            }

        });
    }

    private void actualizarEmpleado(Empleado empleado){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudempleado = retrofit.create(CrudEmpleadoInterface.class);
        Long id = empleado.getId();
        Call<Empleado> call = crudempleado.actualizarEmpleado(id,empleado);

        call.enqueue(new Callback<Empleado>() {

            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response){
                if(!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e("Response error:,", response.message());
                    return;
                }
                Empleado empleado = response.body();
                Log.e("**UPDATE** Nombre empleado editado: ", empleado.getNombre());
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t){
                //System.out.println(t.getMessage());
                Log.e("Throw error: ", t.getMessage());
            }

        });
    }

    private void eliminarEmpleado(Long id){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudempleado = retrofit.create(CrudEmpleadoInterface.class);

        Call<Empleado> call = crudempleado.eliminarEmpleado(id);

        call.enqueue(new Callback<Empleado>() {

            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response){
                if(!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e("Response error:,", response.message());
                    return;
                }
                Empleado empleado = response.body();
                Log.e("**DELETE** Nombre empleado eliminado: ", empleado.getNombre());
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t){
                //System.out.println(t.getMessage());
                Log.e("Throw error: ", t.getMessage());
            }

        });
    }

}