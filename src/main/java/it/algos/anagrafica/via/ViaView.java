package it.algos.anagrafica.via;

import com.vaadin.flow.router.*;
import it.algos.vbase.backend.annotation.*;
import it.algos.vbase.backend.enumeration.*;
import it.algos.vbase.ui.view.*;
import org.springframework.beans.factory.annotation.*;

/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: mer, 25-ott-2023
 * Time: 07:46
 *
 * @Route chiamata dal menu generale o dalla barra del browser <br>
 */
@Route(value = "via", layout = MainLayout.class)
@AView(menuName = "Vie", menuGroup = MenuGroup.anagrafe)
public class ViaView extends CrudView {

    /**
     * Costruttore invocato dalla sottoclasse concreta obbligatoriamente con (almeno) due parametri <br>
     * Mantiene il riferimento al CrudService (singleton) di questo Modulo, iniettato dalla sottoclasse concreta <br>
     * Mantiene il riferimento ad una listClazz (CrudList) per creare l'istanza prototype <br>
     */
    ViaView(@Autowired ViaService moduloService) {
        super(moduloService, ViaList.class);
    }


}// end of @Route CrudView class
