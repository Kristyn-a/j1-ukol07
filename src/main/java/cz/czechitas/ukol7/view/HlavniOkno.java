package cz.czechitas.ukol7.view;

import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.Barva;
import cz.czechitas.ukol7.model.PreferenceBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;


public class HlavniOkno extends JFrame {
    private PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Vyber barvu");
        this.controller = controller;
        this.init();
    }
    public void start(){
        setLocation(null);
        setVisible(true);
    }

    public void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new MigLayout("wrap 4", "[right, 100]rel[50:75:250,grow,fill]" ));
        setMinimumSize(new Dimension(400, 200));

    FormBuilderWithContainer<PreferenceBean> formBuilder = FormBuilder.create(controller.getModel())
            .container(this);

//    ButtonGroup skupina = new ButtonGroup();

    formBuilder
            .label("&Přezdívka")
            .textField("prezdivka")
            .add("right, span");

    for( Barva value : Barva.values()){
    formBuilder
          .radioButton(value.getBarva(), "barva", value)
          .add("left, span");
    }

    formBuilder
            .panel(panel ->{
                JButton ulozitButton = new JButton(controller.getUlozitAction());
                getRootPane().setDefaultButton(ulozitButton);
        panel.add(ulozitButton);
    })
            .add("right, span");
    pack();
    }
}