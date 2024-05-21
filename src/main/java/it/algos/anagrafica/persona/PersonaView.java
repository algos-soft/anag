package it.algos.anagrafica.persona;

import com.vaadin.flow.router.*;
import it.algos.vbase.backend.annotation.*;
import it.algos.vbase.backend.enumeration.*;
import it.algos.vbase.ui.view.*;
import org.springframework.beans.factory.annotation.*;

/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: Thu, 01-Feb-2024
 * Time: 12:28
 *
 * @Route chiamata dal menu generale o dalla barra del browser <br>
 */
@PageTitle("Persone")
@Route(value = "persona", layout = MainLayout.class)
@AView(menuGroup = MenuGroup.anagrafe)
public class PersonaView extends CrudView {


    /**
     * Costruttore alternativo invocato dalla sottoclasse concreta se si usa anche una formClazz specifico <br>
     * Mantiene il riferimento al CrudService Service (singleton) di questo Modulo <br>
     * Mantiene il riferimento ad una listClazz (CrudList) per creare l'istanza prototype <br>
     * Mantiene il riferimento ad una formClazz (CrudForm) per creare l'istanza prototype <br>
     */
    PersonaView(@Autowired PersonaService moduloCrudService) {
        super(moduloCrudService, PersonaList.class, PersonaForm.class);
    }

}// end of @Route CrudView class