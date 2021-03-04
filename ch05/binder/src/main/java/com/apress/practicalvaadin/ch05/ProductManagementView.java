package com.apress.practicalvaadin.ch05;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.HashSet;
import java.util.Set;

@Route("product-management2")
public class ProductManagementView extends Composite {

  private static Set<Product> products = new HashSet<>();
  private VerticalLayout productsLayout = new VerticalLayout();

  @Override
  protected Component initContent() {
    updateList();
    return new VerticalLayout(
        new Button("New product", VaadinIcon.PLUS.create(),
            event -> showProductForm(new Product())),
        productsLayout
    );
  }

  private void updateList() {
    productsLayout.removeAll();
    products.stream()
        .map(product -> new Details(
            product.getName() + (product.isAvailable() ? "" : " (not available)"),
            new HorizontalLayout(
                new Button(VaadinIcon.PENCIL.create(),
                    event -> showProductForm(product)),
                new Button(VaadinIcon.TRASH.create(),
                    event -> delete(product))
            )
        ))
        .forEach(productsLayout::add);
  }

  private void showProductForm(Product product) {
    Dialog dialog = new Dialog();
    dialog.setModal(true);
    dialog.open();

    // dialog.add(new AutomaticProductForm(product, () -> {
    dialog.add(new ProductForm(product, () -> {
      dialog.close();
      save(product);
    }));
  }

  private void save(Product product) {
    products.add(product);
    updateList();
    Notification.show("Product saved: " + product.getName());
  }

  private void delete(Product product) {
    products.remove(product);
    updateList();
    Notification.show("Product deleted");
  }

}
