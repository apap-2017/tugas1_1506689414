package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.model.KotaModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KecamatanModel {
	private int id;
	private String id_kota;
	private String kode_kecamatan;
	private String nama_kecamatan;
	private KotaModel kota;
	
	
	
}
