package it.algos.anagrafica.address;

import it.algos.anagrafica.via.*;
import it.algos.vbase.backend.annotation.*;
import it.algos.vbase.backend.entity.*;
import it.algos.vbase.backend.enumeration.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address")
@AEntity(usaResetStartup = true)
public class AddressEntity extends AbstractEntity {

    @AField(type = TypeField.linkDBRef, widthList = 8, linkClazz = ViaEntity.class)
    @DBRef
    private ViaEntity typeVia;

    @AField(type = TypeField.text, widthList = 14)
    private String indirizzo;

    @AField(type = TypeField.text, widthList = 18)
    private String localita;

    @AField(type = TypeField.text, widthList = 5)
    private String cap;

    @Override
    public String toString() {
        return indirizzo;
    }

}// end of Entity class
