package com.example.appcrud.sinterface;

import com.example.appcrud.model.Empleado;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CrudEmpleadoInterface {
    @GET("/consultarAll")
    Call<List<Empleado>> getAll();

    @GET("/consultar/{id}")
    Call<Empleado> getEmpleado(@Path("id") long id);

    @POST("/guardar")
    Call<Empleado> guardarEmpleado(@Body Empleado empleado);

    @PUT("/actualizar/{id}")
    Call<Empleado> actualizarEmpleado(@Path("id") long id, @Body Empleado empleado);

    @DELETE("/user/{id}")
    Call<Empleado> eliminarEmpleado(@Path("id") long id);
}
