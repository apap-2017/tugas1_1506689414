package com.example.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.model.KelurahanModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeluargaModel {


	private int id; //bigint
	private String nomor_kk;
	private String alamat;  			
	private int RT;						
	private int RW;						
	private String id_kelurahan;		
	private int is_tidak_berlaku; 
	public KelurahanModel kelurahan;
	
	private List <PendudukModel> penduduks; 


	
	

	
	 

	


}
