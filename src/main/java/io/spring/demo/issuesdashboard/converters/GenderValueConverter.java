package io.spring.demo.issuesdashboard.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import io.spring.demo.issuesdashboard.domain.Gender;

@Component
@Converter(autoApply = true)
public class GenderValueConverter implements AttributeConverter<Gender,String>{

	@Override
	public String convertToDatabaseColumn(Gender gender) {
		return gender.getShortName();
	}

	@Override
	public Gender convertToEntityAttribute(String shortName) {
		return Gender.fromShortName(shortName);
	}

}
