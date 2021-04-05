/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.bugs._2393;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Filip Hrisafov
 */
@IssueKey("2393")
@RunWith(AnnotationProcessorTestRunner.class)
@WithClasses({
    Address.class,
    AddressDto.class,
    Country.class,
    CountryDto.class,
})
public class Issue2393Test {

    @Test
    public void shouldUseCorrectImport() {
        AddressDto dto = AddressDto.Converter.INSTANCE.convert( new Address(
            "Zurich",
            new Country( "Switzerland" )
        ) );

        assertThat( dto.getCity() ).isEqualTo( "Zurich" );
        assertThat( dto.getCountry().getName() ).isEqualTo( "Switzerland" );
        assertThat( dto.getCountry().getCode() ).isEqualTo( "UNKNOWN" );
    }
}
