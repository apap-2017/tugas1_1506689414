package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import com.example.model.KeluargaModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendudukModel {
	
	@NotNull(message = "id cannot be empty")
	private int id;  //bigint
	
	@NotNull(message = "nik cannot be empty")
	private String nik; 
	
	@NotNull(message = "nama cannot be empty")
	private String nama; //varchar
	
	@NotNull(message = "tempat_lahir cannot be empty")
	private String tempat_lahir; //varchar
	
	@NotNull(message = "tanggal_lahir cannot be empty")
	private String tanggal_lahir;
	
	@NotNull(message = "jenis_kelamin cannot be empty")
	private String jenis_kelamin;
	
	@NotNull(message = "is_wni cannot be empty")
	private String is_wni; //tinyint
	
	@NotNull(message = "id_keluarga cannot be empty")
	private String id_keluarga; //bigint
	
	
	
	@NotNull(message = "agama cannot be empty")
	private String agama; //varchar
	
	@NotNull(message = "pekerjaan cannot be empty")
	private String pekerjaan; //occupation
	
	@NotNull(message = "status_perkawinan cannot be empty")
	private String status_perkawinan;  //varchar	
	
	@NotNull(message = "status_dalam_keluarga cannot be empty")
	private String status_dalam_keluarga;  //varchar
	
	@NotNull(message = "golongan_darah cannot be empty")
	private String golongan_darah;  //varchar
	
	@NotNull(message = "is_wafat cannot be empty")
	private String is_wafat; //tinyint

	
	private KeluargaModel keluarga;
	
	
	 public String getId_keluarga() {
	  		return id_keluarga;
	      	
	 }
	      
	 public void setId_keluarga(String id_keluarga) {
	      	this.id_keluarga=id_keluarga;
	 }
	

	



	
	

} 


