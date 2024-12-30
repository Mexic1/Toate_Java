package com.example.repository;


import java.util.List;
import com.example.Masini;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MasinaJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Masini> findAll(){
        TypedQuery<Masini> query=entityManager.createQuery("from Masini",Masini.class);
        return query.getResultList();
    }
    public Masini findById(String id){
        return entityManager.find(Masini.class, id);
    }
    public void deleteById(String id){
        Masini masini=findById(id);
        entityManager.remove(masini);
    }
    public Masini insert(Masini masini){
        return entityManager.merge(masini);
    }
    public Masini update(Masini masini){
        return entityManager.merge(masini);
    }


}
