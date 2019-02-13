package com.example.core.data.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import com.example.core.data.network.Content as nwContent
import com.example.core.data.database.model.Content as dbContent

/**
 *
 * Notes :
 * 1. Map Struct Example
 * https://github.com/mapstruct/mapstruct-examples/tree/master/mapstruct-kotlin/src
 *
 * 2. StackOverflow
 * https://softwareengineering.stackexchange.com/questions/368878/data-objects-for-each-layerdto-vs-entity-vs-response-objects
 * 
 */
@Mapper
interface ContentMapper {

    fun convertToDbContent(content: nwContent): dbContent

}
