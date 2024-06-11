package it.algos.anagrafica.persona;

import it.algos.anagrafica.address.AddressEntity;
import it.algos.vbase.backend.annotation.AEntity;
import it.algos.vbase.backend.annotation.AFieldList;
import it.algos.vbase.backend.entity.AbstractEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import static it.algos.vbase.backend.boot.BaseCost.SPAZIO;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "persona")
@AEntity()
public class PersonaEntity extends AbstractEntity {

    @AFieldList(width = 6)
    private String titolo;

    @AFieldList()
    private String nome;

    @AFieldList()
    private String cognome;

    @AFieldList(width = 8)
    private String telefono;

    @AFieldList(width = 16)
    private String mail;

    @AFieldList()
//    @AField(type = TypeField.linkDBRef)
    private AddressEntity address;

    @Override
    public String toString() {
        return nome + SPAZIO + cognome;
    }

}// end of Entity class
