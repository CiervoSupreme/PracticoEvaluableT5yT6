package org.example.practicoevaluablet5yt6.repository;

import org.example.practicoevaluablet5yt6.Collections.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repositorio de Spring Data para la entidad {@link Item}.
 * Proporciona métodos CRUD (Crear, Leer, Actualizar, Borrar) para los hoteles
 * interactuando con la base de datos MongoDB.
 */
public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByCategory(String category);

    List<Item> findByCountLessThan(int stock);

    @Query(value = "{}", fields = "{ 'manufacturer' : 1, '_id' : 0 }")
    List<Item> findAllManufacturers();
}
