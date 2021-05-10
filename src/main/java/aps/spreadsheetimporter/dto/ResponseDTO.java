package aps.spreadsheetimporter.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO<T> {
	private T data;
	private List<T> dataSet;
	
	public ResponseDTO(final T data){
		this.data = data;
	}
	
	public ResponseDTO(final List<T> dataSet){
		this.dataSet = dataSet;
	}
}