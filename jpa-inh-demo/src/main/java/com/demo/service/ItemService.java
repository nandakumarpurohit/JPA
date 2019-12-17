package com.demo.service;

import javax.persistence.EntityManager;

import com.demo.model.Book;
import com.demo.model.CD;

public class ItemService {

  private EntityManager em;

  public ItemService(EntityManager em) {
    this.em = em;
  }

  public CD createCD(CD cd) {
    em.persist(cd);
    return cd;
  }

  public void removeCD(CD cd) {
    em.remove(em.merge(cd));
  }

  public CD findCD(Long id) {
    return em.find(CD.class, id);
  }

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public void removeBook(Book book) {
    em.remove(em.merge(book));
  }

  public Book findBook(Long id) {
    return em.find(Book.class, id);
  }
}