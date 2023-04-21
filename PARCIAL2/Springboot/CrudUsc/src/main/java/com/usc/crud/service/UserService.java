package com.usc.crud.service;

import com.usc.crud.model.Empleado;
import com.usc.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<Empleado> finByUser(Empleado empleado){

        return repository.findById(empleado.getId());

    }
    public Empleado guardarUser(Empleado empleado){

        return repository.save (empleado);

    }
    public List<Empleado> buscarTodos(){

        return (List<Empleado>) repository.findAll();

    }
    public String  eliminarUser(Long id){

        String msj = "";
        Optional<Empleado> userDb = repository.findById (id);
        if(!userDb.isEmpty()){
            repository.delete(userDb.get());
            msj = "usuario eliminado correctamente";
        }
        else{
            msj = "El usuario ingresado no se encuentra registrado.";
        }

    return msj;
    }

    public String actualizarUsuario(Long id, Empleado empleado){

        String msj = "";
        Empleado updateEmployee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setNombre(empleado.getNombre());
        updateEmployee.setEmail(empleado.getEmail());
        updateEmployee.setPassword(empleado.getPassword());

        repository.save(updateEmployee);
        msj = "El usuario ingresado no se encuentra registrado.";


        return msj;

    }
}
