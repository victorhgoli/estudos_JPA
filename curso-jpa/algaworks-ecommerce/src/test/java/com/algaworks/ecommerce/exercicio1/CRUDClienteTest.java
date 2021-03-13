package com.algaworks.ecommerce.exercicio1;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;

import org.junit.Assert;
import org.junit.Test;

public class CRUDClienteTest extends EntityManagerTest {

    @Test
    public void createCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome("tiao");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente persistedCliente = entityManager.find(Cliente.class, cliente.getId());

        Assert.assertNotNull(persistedCliente);
    }

    @Test
    public void readCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertNotNull(cliente);
    }

    @Test
    public void updateCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        cliente.setNome("Joao");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteUpdated = entityManager.find(Cliente.class, 2);

        Assert.assertEquals("Joao", clienteUpdated.getNome());

    }

    @Test
    public void deleteCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteDeleted = entityManager.find(Cliente.class, 2);

        Assert.assertNull(clienteDeleted);

    }

}
