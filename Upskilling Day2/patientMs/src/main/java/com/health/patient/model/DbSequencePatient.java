package com.health.patient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.health.patient.model.DbSequencePatient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor

	public class DbSequencePatient {
	    @Id
	    private String  id;
	    private int seq;
		public int getSeq() {
			// TODO Auto-generated method stub
			return seq;
		}
}
		