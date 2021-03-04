package com.apress.practicalvaadin.ch05;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.function.SerializableRunnable;

public class ProductForm extends Composite {

  private final SerializableRunnable saveListener;
  private TextField name = new TextField("Name");
  private Checkbox available = new Checkbox("Available");
  private Product product;

  public ProductForm(Product product, SerializableRunnable saveListener) {
    this.product = product;
    this.saveListener = saveListener;

    if (product.getName() != null) {
      name.setValue(product.getName());
      available.setValue(product.isAvailable());
    }
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new H1("Product"),
        name,
        available,
        new Button("Save", VaadinIcon.CHECK.create(),
            event -> saveClicked())
    );
  }

  private void saveClicked() {
    product.setName(name.getValue());
    product.setAvailable(available.getValue());
    saveListener.run();
  }

}
