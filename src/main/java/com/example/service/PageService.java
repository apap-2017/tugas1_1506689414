package com.example.service;

import java.util.List;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;

public interface PageService {

	KeluargaModel selectKeluargaKK (String nkk);
	KeluargaModel selectKeluarga (String nik);
	List<PendudukModel> selectPenduduks(String nkk) ;
	KelurahanModel selectKelurahan(String id_kelurahan);
	KecamatanModel selectKecamatan (String id_kecamatan);
	KotaModel selectKota(String id_kota);
	KelurahanModel selectIDKelurahan(String nama_kelurahan);
	KecamatanModel selectIDKecamatan(String nama_kecamatan);
	KotaModel selectIDKota(String nama_kota);
	KecamatanModel selectKodeKecamatan(String nama_kecamatan);
	PendudukModel updatePenduduk();
	KeluargaModel updateKeluarga();
	PendudukModel selectPenduduk (String nik);
	List<PendudukModel> selectAllPenduduk ();
	PendudukModel tambahPenduduk(PendudukModel penduduk);
	void updatePenduduk(PendudukModel penduduk);
	KeluargaModel tambahKeluarga(KeluargaModel keluarga);
	void updateKeluarga (KeluargaModel keluarga);
}
