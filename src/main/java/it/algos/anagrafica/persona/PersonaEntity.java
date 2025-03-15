package it.algos.anagrafica.persona;

import it.algos.anagrafica.address.AddressEntity;
import it.algos.vbase.annotation.IEntity;
import it.algos.vbase.annotation.IFieldList;
import it.algos.vbase.entity.AbstractEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import static it.algos.vbase.boot.BaseCost.SPAZIO;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "persona")
@IEntity()
public class PersonaEntity extends AbstractEntity {

    @IFieldList(width = 6)
    private String titolo;

    @IFieldList()
    private String nome;

    @IFieldList()
    private String cognome;

    @IFieldList(width = 8)
    private String telefono;

    @IFieldList(width = 16)
    private String mail;

    @IFieldList()
    private AddressEntity address;

    @Override
    public String toString() {
        return nome + SPAZIO + cognome;
    }

}// end of Entity class
