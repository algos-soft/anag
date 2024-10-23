package it.algos.anagrafica.via;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import it.algos.vbase.annotation.IView;
import it.algos.vbase.constant.Gruppo;
import it.algos.vbase.ui.view.AView;
import it.algos.vbase.ui.view.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;


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
@IView( menuGroup = Gruppo.ANAG, menuName = "Vie", lumo = LumoIcon.ARROW_DOWN)
public class ViaView extends AView {

    /**
     * Costruttore invocato dalla sottoclasse concreta obbligatoriamente con (almeno) due parametri <br>
     * Mantiene il riferimento al CrudService (singleton) di questo Modulo, iniettato dalla sottoclasse concreta <br>
     * Mantiene il riferimento ad una listClazz (AList) per creare l'istanza prototype <br>
     */
    ViaView(@Autowired ViaService moduloService) {
        super(moduloService, ViaList.class);
    }


}// end of @Route CrudView class
