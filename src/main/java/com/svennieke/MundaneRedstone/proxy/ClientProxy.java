package com.svennieke.MundaneRedstone.proxy;

import com.svennieke.MundaneRedstone.init.ModBlocks;

public class ClientProxy extends ServerProxy{

	public void Preinit() {
		ModBlocks.registerRenders();
	}

	public void Init() {
		
	}
}
