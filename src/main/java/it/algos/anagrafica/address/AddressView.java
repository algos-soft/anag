package it.algos.anagrafica.address;

import com.vaadin.flow.router.Route;
import it.algos.vbase.backend.annotation.AView;
import it.algos.vbase.backend.constant.Gruppo;
import it.algos.vbase.ui.view.CrudView;
import it.algos.vbase.ui.view.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: Thu, 01-Feb-2024
 * Time: 11:53
 *
 * @Route chiamata dal menu generale o dalla barra del browser <br>
 */
@Route(value = "address", layout = MainLayout.class)
@AView(menuGroup = Gruppo.UTILITY, menuName = "Address")
public class AddressView extends CrudView {


    /**
     * Costruttore alternativo invocato dalla sottoclasse concreta se si usa anche una formClazz specifico <br>
     * Mantiene il riferimento al moduloService (singleton) di questo Modulo <br>
     * Mantiene il riferimento ad una listClazz (CrudList) per creare l'istanza prototype <br>
     * Mantiene il riferimento ad una formClazz (CrudForm) per creare l'istanza prototype <br>
     */
    AddressView(@Autowired AddressService moduloService) {
        super(moduloService, AddressList.class, AddressForm.class);
    }

}// end of @Route CrudView class
