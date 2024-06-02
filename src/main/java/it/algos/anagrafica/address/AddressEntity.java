package it.algos.anagrafica.address;

import it.algos.anagrafica.via.*;
import it.algos.vbase.backend.annotation.*;
import it.algos.vbase.backend.entity.*;
import it.algos.vbase.backend.enumeration.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address")
@AReset()
@AEntity()
public class AddressEntity extends AbstractEntity {

    @AFieldList(width = 8)
    @AField(type = TypeField.linkDBRef, linkClazz = ViaEntity.class)
    @DBRef
    private ViaEntity typeVia;

    @AFieldList(width = 14)
    @AField(type = TypeField.text)
    private String indirizzo;

    @AFieldList(width = 18)
    @AField(type = TypeField.text)
    private String localita;

    @AFieldList(width = 5)
    @AField(type = TypeField.text)
    private String cap;

    @Override
    public String toString() {
        return indirizzo;
    }

}// end of Entity class
