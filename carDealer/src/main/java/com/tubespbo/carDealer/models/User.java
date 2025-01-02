package com.tubespbo.carDealer.models;

import jakarta.persistence.*;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Strategi Single Table
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING) // Kolom untuk tipe user
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    
    private String username;
    private String password;
    private String nama;
    private String noTelp;
    @Column(name = "role", insertable = false, updatable = false)
    private String role;

    public String getRole() {
        return role;
    }
    
    public User(){
        
    }
    public User(int idUser, String username, String password, String nama, String role, String noTelp) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.noTelp = noTelp;
    }
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}

