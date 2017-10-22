package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;

@Mapper
public interface PageMapper {
	

	 @Select("select * from penduduk p, keluarga k, kelurahan a, kecamatan b, kota c where p.id_keluarga=k.id AND k.id_kelurahan=a.id AND a.id_kecamatan=b.id AND b.id_kota=c.id AND nik=#{nik}")
	 @Results (value = {
			 @Result (property="nik", column="nik"), 
			 @Result (property="nama", column="nama"),
			 @Result (property="tempat_lahir", column="tempat_lahir"),
			 @Result (property="tanggal_lahir", column="tanggal_lahir"),
			 @Result (property="jenis_kelamin", column="jenis_kelamin"),
			 @Result (property="is_wni", column="is_wni"),
			 @Result (property="id_keluarga", column="id_keluarga"),
			 @Result (property="agama", column="agama"),
			 @Result (property="pekerjaan", column="pekerjaan"),
			 @Result (property="status_perkawinan", column="status_perkawinan"),
			 @Result (property="status_dalam_keluarga", column="status_dalam_keluarga"),
			 @Result (property="golongan_darah", column= "golongan_darah"),
			 @Result (property="is_wafat", column="is_wafat"),
			  @Result (property="keluarga", column="id_keluarga",
					 javaType = KeluargaModel.class, many= @Many(select= "selectKeluarga"))
		
	 })  
	 	 PendudukModel selectPenduduk (@Param("nik") String nik);
	 
	//SELECT KELUARGA
	//untuk view keluarga yang diambil
	@Select ("select * from keluarga k, kelurahan a, kecamatan b, kota c  where a.id=k.id_kelurahan AND a.id_kecamatan=b.id AND b.id_kota=c.id AND k.id=#{id_keluarga}")
	@Results (value= {
			 @Result (property="nomor_kk", column="nomor_kk"),
			 @Result (property="alamat", column="alamat"),
			 @Result (property="RW", column="RW"),
			 @Result (property="RT", column="RT"),
			 @Result (property="id", column="id"),
			 @Result (property="id_kelurahan", column="id_kelurahan"),
	 		 @Result (property="is_tidak_berlaku", column="is_tidak_berlaku"),
	 		 @Result (property="kelurahan", column="id_kelurahan",
	 			 	javaType = KelurahanModel.class, many= @Many(select= "selectKelurahan"))
		 			
	 	})
		KeluargaModel selectKeluarga(@Param("id_keluarga") String id_keluarga);
	 
	 
	//SELECT KELURAHAN
	@Select("select * from kelurahan where kelurahan.id=#{id_kelurahan}")
	@Results(value = {
			 @Result (property="id", column="id"),
			 @Result (property="id_kecamatan", column="id_kecamatan"),
			 @Result (property="nama_kelurahan", column="nama_kelurahan"),
			 @Result (property="kode_pos", column="kode_pos"),
			 @Result (property="kecamatan", column="id_kecamatan",
			 		javaType = KecamatanModel.class, many= @Many(select= "selectKecamatan"))
	 })
	 KelurahanModel selectKelurahan(@Param("id_kelurahan") String id_kelurahan);
	
	@Select("select * from kelurahan")
	List<KelurahanModel> selectKelurahanList();
	 
	 
	//SELECT KECAMATAN
	@Select("select * from kecamatan  where kecamatan.id=#{id_kecamatan}")
	@Results(value = {
			 @Result (property="id", column="id"),
			 @Result (property="id_kota", column="id_kota"),
			 @Result (property="kode_kecamatan", column="kode_kecamatan"),
			 @Result (property="nama_kecamatan", column="nama_kecamatan"),
			 @Result (property="kota", column="id_kota",
			 	javaType = KelurahanModel.class, many= @Many(select= "selectKota"))
	 		
			 
	 })
	KecamatanModel selectKecamatan(@Param("id_kecamatan") String id_kecamatan);
	 
	@Select("select * from kecamatan")
	List<KecamatanModel> selectKecamatanList();
	
	//SELECT KOTA
	@Select("select * from kota where kota.id=#{id_kota}")
	@Results(value = {
			@Result (property="id", column="id"),
			@Result (property="id_kota", column="id_kota"),
			@Result (property="nama_kota", column="nama_kota"),
			 
	 })
	 KotaModel selectKota(@Param("id_kota") String id_kota);
	
	@Select("select * from kota")
	List<KotaModel> selectKotaList();
	 
	@Select("select * from penduduk") 
	List <PendudukModel> selectAllPenduduk();
	 
	@Select("insert into penduduk(nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat)"
			+ " values(#{nik},#{nama},#{tempat_lahir},#{tanggal_lahir},#{jenis_kelamin},#{is_wni},#{id_keluarga},#{agama},#{pekerjaan},#{status_perkawinan},#{status_dalam_keluarga},#{golongan_darah},#{is_wafat})") 
	PendudukModel tambahPenduduk(PendudukModel penduduk);
	
	@Update("update penduduk set nik=#{nik}, nama=#{nama} , tempat_lahir=#{tempat_lahir} , tanggal_lahir=#{tanggal_lahir} , jenis_kelamin=#{jenis_kelamin} , is_wni=#{is_wni} , id_keluarga=#{id_keluarga} , "
			+ "agama=#{agama} , pekerjaan=#{pekerjaan} , status_perkawinan=#{status_perkawinan} , status_dalam_keluarga=#{status_dalam_keluarga} , golongan_darah=#{golongan_darah} , is_wafat=#{is_wafat} "
			+ "where id=#{id}")
	void updatePenduduk(PendudukModel penduduk);
	
	
		
	@Select("insert into keluarga(id, nomor_kk, alamat, RT, RW, id_kelurahan, is_tidak_berlaku) "
			+ "values(#{id},#{nomor_kk},#{alamat},#{RT},#{RW},#{id_kelurahan},#{is_tidak_berlaku})")		
	KeluargaModel tambahKeluarga(KeluargaModel keluarga);
	
	@Update("update keluarga set nomor_kk =#{nomor_kk}, alamat=#{alamat}, RT=#{RT}, RW=#{RW}, id_kelurahan=#{id_kelurahan}, "
			+ "is_tidak_berlaku=#{is_tidak_berlaku}"
			+ "where id=#{id}")
		void updateKeluarga(KeluargaModel keluarga);
	
	@Select("select id from kelurahan where nama_kelurahan=#{nama_kelurahan}")
		@Results (value = {
		@Result (property="nama_kelurahan", column="nama_kelurahan")
	})
	KelurahanModel selectIDKelurahan(@Param ("nama_kelurahan") String nama_kelurahan);
	
	@Select("select id from kecamatan where nama_kecamatan=#{nama_kecamatan}")
		@Results(value = {
		@Result (property="nama_kecamatan", column="nama_kecamatan")
		})
	KecamatanModel selectIDKecamatan(@Param ("nama_kecamatan")String nama_kecamatan);
	

	@Select("select id from kota where nama_kota=#{nama_kota}")
		@Results(value = {
		@Result (property="nama_kota", column="nama_kota")
		})
	KotaModel selectIDKota(@Param ("nama_kota")String nama_kota);
	
	
	
	@Select("select kode_kecamatan from kecamatan where nama_kecamatan=#{nama_kecamatan}")
	@Results (value = {
			@Result (property="nama_kecamatan", column="nama_kecamatan")
	})
	KecamatanModel selectKodeKecamatan(@Param ("nama_kecamatan") String nama_kecamatan);
	 
	 
	
		
	//untuk view keluarga yang diambil
	@Select ("select * from keluarga k, kelurahan a, kecamatan b, kota c  where a.id=k.id_kelurahan AND a.id_kecamatan=b.id AND b.id_kota=c.id AND k.nomor_kk=#{nkk}")
	@Results (value= {
		 	@Result (property="id", column="id"),
		 	@Result (property="nomor_kk", column="nomor_kk"),
		 	@Result (property="alamat", column="alamat"),
		 	@Result (property="RW", column="RW"),
		 	@Result (property="RT", column="RT"),
		 	@Result (property="id_kelurahan", column="id_kelurahan"),
		 	@Result (property="kelurahan", column="id_kelurahan",
		 		javaType = KelurahanModel.class, many= @Many(select= "selectKelurahan")),
		 	@Result (property="penduduks", column="nomor_kk", 
				javaType = List.class, many= @Many(select= "selectPenduduks"))
		 	})
	KeluargaModel selectKeluargaKK (@Param("nkk") String nkk);
		 
		 
	 //Select anggota keluarga
	 //Mengembalikan List of Penduduk dari penduduk  dengan penduduk.id_keluarga = keluarga.id
	 @Select("select * from penduduk p, keluarga k where p.id_keluarga=k.id AND nomor_kk=#{nkk}")
	 List<PendudukModel> selectPenduduks(@Param("nkk") String nkk);
		 
		    
	 @Select("select * from keluarga") 
	 List <KeluargaModel> selectAllKeluarga();

		
		    
			    
	
	
	
	
	
	
	
	
}
