package it.algos.anagrafica.via;

import it.algos.vbase.annotation.*;
import it.algos.vbase.entity.AbstractEntity;
import it.algos.vbase.enumeration.TextSearchMode;
import lombok.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "via")
@IReset()
@IEntity()
public class ViaEntity extends AbstractEntity {

    @IFieldList(headerText = "#")
    private int ordine;

    @Indexed(unique = true)
    @ISearch(textSearchMode = TextSearchMode.startsWith)
    @IFieldList(headerText = "Nome")
    @IFieldForm(label = "Nome")
    private String code;

    @Override
    public String toString() {
        return code;
    }

}// end of Entity class
