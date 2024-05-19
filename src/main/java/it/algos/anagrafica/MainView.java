package it.algos.anagrafica;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.*;
import it.algos.vbase.ui.view.*;

/**
 * Project crono
 * Created by Algos
 * User: gac
 * Date: dom, 19-mag-2024
 * Time: 09:31
 */
//@Route("x") // map view to the root
@Route(value = "", layout = MainLayout.class)
class MainView extends VerticalLayout {

    MainView() {
        add(new H1("Hello, world"));
    }

}
