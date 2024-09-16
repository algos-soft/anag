package it.algos.anagrafica.persona;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import it.algos.vbase.backend.annotation.AViewList;
import it.algos.vbase.backend.components.SimpleVerticalLayout;
import it.algos.vbase.backend.list.AList;
import it.algos.vbase.ui.wrapper.ASpan;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@SpringComponent
@Scope(value = SCOPE_PROTOTYPE)
@AViewList()
public class PersonaList extends AList {


    /**
     * Costruttore invocato dalla sottoclasse concreta obbligatoriamente con un parametro <br>
     * Mantiene il riferimento ad una istanza prototype della CrudView <br>
     */
    public PersonaList(final PersonaView parentCrudView) {
        super(parentCrudView);
    }

//    protected void fixPreferenze() {
//        this.usaBottoneResetDelete = true;
//        this.usaBottoneResetAdd = false;
//    }

    @Override
    public void fixHeader() {
        VerticalLayout layout = new SimpleVerticalLayout();
        layout.add(ASpan.text(String.format("Prova")).verde());

        super.fixHeader();
    }

}// end of AList class
