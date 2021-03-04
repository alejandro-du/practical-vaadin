package com.apress.practicalvaadin.ch05;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.function.SerializableRunnable;

public class AutomaticProductForm extends Composite {

  private final SerializableRunnable saveListener;

  @PropertyId("name")
  private TextField nameField = new TextField("Name");

  @PropertyId("available")
  private Checkbox availableField = new Checkbox("Available");

  public AutomaticProductForm(Product product, SerializableRunnable saveListener) {
    this.saveListener = saveListener;

    Binder<Product> binder = new Binder<>(Product.class);
    binder.bindInstanceFields(this);
    binder.setBean(product);
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new H1("Product"),
        nameField,
        availableField,
        new Button("Save", VaadinIcon.CHECK.create(),
            event -> saveListener.run())
    );
  }

}
