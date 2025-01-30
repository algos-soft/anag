package it.algos.anagrafica.address;

import it.algos.anagrafica.via.*;
import it.algos.vbase.enumeration.RisultatoReset;
import it.algos.vbase.service.ModuloService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import static it.algos.vbase.boot.BaseCost.VUOTA;

/**
 * Project base24
 * Created by Algos
 * User: gac
 * Date: Thu, 01-Feb-2024
 * Time: 11:53
 */
@Service
public class AddressService extends ModuloService {

    @Autowired
    ViaService viaModulo;

    /**
     * Costruttore invocato dalla sottoclasse concreta obbligatoriamente con due parametri <br>
     * Regola la entityClazz associata a questo Modulo <br>
     * Regola la viewClazz @Route associata a questo Modulo <br>
     */
    public AddressService() {
        super(AddressEntity.class);
    }



    /**
     * Creazione in memoria di una nuova entity che NON viene salvata <br>
     *
     * @return la nuova entity appena creata (con keyID ma non salvata)
     */
    @Override
    public AddressEntity newEntity() {
        return newEntity(null, VUOTA, VUOTA, VUOTA);
    }

    public AddressEntity newEntity(String indirizzo, String localita) {
        return newEntity(null, indirizzo, localita, VUOTA);
    }

    /**
     * Creazione in memoria di una nuova entity che NON viene salvata <br>
     *
     * @param typeVia   (obbligatorio)
     * @param indirizzo (obbligatorio)
     * @param localita  (obbligatorio)
     * @param cap       (facoltativo)
     *
     * @return la nuova entity appena creata (con keyID ma non salvata)
     */
    public AddressEntity newEntity(ViaEntity typeVia, String indirizzo, String localita, String cap) {
        AddressEntity newEntityBean = AddressEntity.builder()
                .typeVia(typeVia)
                .indirizzo(textService.isValid(indirizzo) ? indirizzo : null)
                .localita(textService.isValid(localita) ? localita : null)
                .cap(textService.isValid(cap) ? cap : null)
                .build();

        return newEntityBean;
    }

//    @Override
//    public AddressEntity findByKey(final Object keyPropertyValue) {
//        return (AddressEntity) super.findByKey(keyPropertyValue);
//    }

    @Override
    public RisultatoReset reset() {
//        ViaEntity viaBean0 = viaModulo.findByCode("via");
//        ViaEntity viaBean1 = viaModulo.findByCode("viale");
//        ViaEntity viaBean2 = viaModulo.findByCode("piazza");
//
//        insert(newEntity("Romagna, 17", "Milano"));
//        insert(newEntity(viaBean1, "Romagna, 17", "Milano", "20121"));
//        insert(newEntity(null, "Trinità de' Monti, 2", "Roma", "60102"));
//        insert(newEntity(viaBean2, "Trinità de' Monti, 2", "Roma", "60102"));
//        insert(newEntity(viaBean0, "Roma, 4", "San Valentino in Abruzzo Citeriore", "37234"));

        return RisultatoReset.vuotoMaCostruito;
    }

}// end of CrudService class
