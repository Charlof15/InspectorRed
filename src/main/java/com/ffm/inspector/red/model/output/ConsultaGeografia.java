package com.ffm.inspector.red.model.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaGeografia {
	
	private String clusterTotalplay;
	
	@Override
	public String toString() {
		return clusterTotalplay;
	}

}
