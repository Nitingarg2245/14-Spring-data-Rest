package com.example.entity;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "books")
public interface BookInterface extends JpaRepository<Book,Integer> {
    public List<Book> findByNameContaining(@Param("name")String name);
}
