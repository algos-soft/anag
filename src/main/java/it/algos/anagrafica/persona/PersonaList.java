package it.algos.anagrafica.persona;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import it.algos.vbase.backend.annotation.AList;
import it.algos.vbase.backend.components.SimpleVerticalLayout;
import it.algos.vbase.backend.list.CrudList;
import it.algos.vbase.ui.wrapper.ASpan;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@SpringComponent
@Scope(value = SCOPE_PROTOTYPE)
@AList(gridFooterRow = true)
public class PersonaList extends CrudList {


    /**
     * Costruttore invocato dalla sottoclasse concreta obbligatoriamente con un parametro <br>
     * Mantiene il riferimento ad una istanza prototype della CrudView <br>
     */
    public PersonaList(final PersonaView parentCrudView) {
        super(parentCrudView);
    }

    protected void fixPreferenze() {
        this.usaBottoneResetDelete = true;
        this.usaBottoneResetAdd = false;
    }

    @Override
    public void syncHeader() {
        VerticalLayout layout = new SimpleVerticalLayout();
        layout.add(ASpan.text(String.format("Prova")).verde());

        super.fixHeaderPost();
    }

}// end of CrudList class
