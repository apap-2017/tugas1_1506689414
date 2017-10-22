package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PageMapper;
import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PageSeriveDatabase implements PageService {
	
	@Autowired
	private PageMapper siduk;
	

	
	@Override
	public PendudukModel selectPenduduk (String nik) {
		log.info("Select penduduk with nik {}", nik);
		return siduk.selectPenduduk(nik);
	}
	
	@Override
	public List<PendudukModel> selectAllPenduduk() {
		log.info("Select all penduduk");
		return siduk.selectAllPenduduk();
	}
	

	public PendudukModel tambahPenduduk(PendudukModel penduduk) {
		log.info("tambah penduduk");
		return siduk.tambahPenduduk(penduduk);
		
	}
	

	
	public KeluargaModel tambahKeluarga(KeluargaModel keluarga) {
		log.info("tambah keluarga");
		return siduk.tambahKeluarga(keluarga);
		
	}
	
	public void updatePenduduk(PendudukModel penduduk) {
		log.info("penduduk "  + penduduk.getId() +  " updated");
		siduk.updatePenduduk(penduduk);
	}
	
	public void updateKeluarga(KeluargaModel keluarga) {
		log.info("keluarga " + keluarga.getId() + " updated");
		siduk.updateKeluarga(keluarga);
	}
	
	
	@Override
	public KeluargaModel selectKeluargaKK (String nkk) {
		log.info("Select keluarga with nomor_kk {}", nkk);
		return siduk.selectKeluargaKK(nkk);
	}


	@Override
	public KeluargaModel selectKeluarga(String id_keluarga) {
		log.info("Select keluarga with id_keluarga {}", id_keluarga);
		return siduk.selectKeluarga(id_keluarga);
	}	
	
	

	@Override
	public KelurahanModel selectKelurahan(String id_kelurahan) {
		log.info("Select kelurahan with id_kelurahan {}", id_kelurahan);
		return siduk.selectKelurahan(id_kelurahan);
	}	
	
	@Override
	public KelurahanModel selectIDKelurahan(String nama_kelurahan) {
		log.info("Select nama kelurahan{}", nama_kelurahan);
		return siduk.selectIDKelurahan(nama_kelurahan);
	}
	

	@Override
	public KecamatanModel selectIDKecamatan(String nama_kecamatan) {
		log.info("Select nama kecamatan{}", nama_kecamatan);
		return siduk.selectIDKecamatan(nama_kecamatan);
	}
	

	@Override
	public KotaModel selectIDKota(String nama_kota) {
		log.info("Select nama kota{}", nama_kota);
		return siduk.selectIDKota(nama_kota);
	}
	
	
	@Override
	public KecamatanModel selectKodeKecamatan(String nama_kecamatan) {
		log.info("Select kode kecamatan");
		return siduk.selectKodeKecamatan(nama_kecamatan);
	}

	@Override
	public KecamatanModel selectKecamatan(String id_kecamatan) {
		log.info("Select kecamatan with id_kecamatan {}", id_kecamatan);
		return siduk.selectKecamatan(id_kecamatan);
	}	

	
	@Override
	public KotaModel selectKota(String id_kota) {
		log.info("Select kota with id_kota {}", id_kota);
		return siduk.selectKota(id_kota);
	}	


	public List<PendudukModel> selectPenduduks(String nkk) {
		log.info("Select anggota keluarga dari penduduks {}", nkk);
		return siduk.selectPenduduks(nkk);
	}	

	
	@Override
	public PendudukModel updatePenduduk() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeluargaModel updateKeluarga() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
