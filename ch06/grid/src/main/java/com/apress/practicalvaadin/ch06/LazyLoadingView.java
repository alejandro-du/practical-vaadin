package com.apress.practicalvaadin.ch06;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("lazy-loading")
public class LazyLoadingView extends Composite {

  @Override
  protected Component initContent() {
    var grid = new Grid<Book>();
    grid.addColumn(Book::getTitle).setHeader("Book").setAutoWidth(true);
    grid.addColumn(book -> book.getPublisher().getName()).setHeader("Publisher");
    grid.addColumn(Book::getAuthor).setHeader("Author");
    grid.addColumn(Book::getQuantity).setHeader("Quantity");

    grid.setItems(query -> BookService.findAll(
        query.getOffset(), query.getLimit()).stream()
    );

    return new VerticalLayout(grid);
  }

}
