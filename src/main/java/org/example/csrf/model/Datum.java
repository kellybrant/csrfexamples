package org.example.csrf.model;

import lombok.Data;

@Data
public class Datum {

	private String create;
	private String recall;
	private String update;
	private String delete;

	public Datum() { }

	@Override
	public String toString() {
		return new StringBuilder()
				.append("\ncreate : ").append(create)
				.append("\nrecall : ").append(recall)
				.append("\nupdate : ").append(update)
				.append("\ndelete : ").append(delete)
				.append("\n")
				.toString();
	}

}
