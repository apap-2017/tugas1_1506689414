package com.example.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.model.KecamatanModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KelurahanModel {
	private int id;
	private String id_kecamatan;
	private String kode_kelurahan;
	private String nama_kelurahan;
	private int kode_pos;
	private KecamatanModel kecamatan;

}
