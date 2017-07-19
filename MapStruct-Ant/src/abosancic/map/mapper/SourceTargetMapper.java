/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package abosancic.map.mapper;

/**
 *
 * @author abosancic
 */
import abosancic.map.models.Source;
import abosancic.map.models.dto.Target;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)// inject date time formated
public interface SourceTargetMapper
{

    SourceTargetMapper INSTANCE = Mappers.getMapper(SourceTargetMapper.class);

    @Mappings({
        @Mapping(source = "qax", target = "baz"),
        @Mapping(source = "baz", target = "qax"),
        @Mapping(source = "date", target = "dateFormated")
    })
    Target sourceToTarget(Source source);

    @InheritInverseConfiguration
    Source targetToSource(Target target);
}
