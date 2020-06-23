package com.cdm.microserviciocurso.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumnos;
    @Column
    private String Nombre;
    @Column
    private String Apellido;
    @Column
    private String email;
    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void fechaCreacion(){
        this.createAt = new Date();
    }

    public Long getIdAlumnos() {
        return idAlumnos;
    }

    public void setIdAlumnos(Long idAlumnos) {
        this.idAlumnos = idAlumnos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Alumno)){
            return false;
        }

        Alumno alumno = (Alumno) obj;

        return this.idAlumnos != null && this.idAlumnos.equals(alumno.getIdAlumnos());
    }
}
