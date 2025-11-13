/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monitor;

/**
 *
 * @author vince
 */

import oshi.SystemInfo;
import oshi.hardware.*;
import java.util.List; 

public class HardwareInfo {
    private final SystemInfo si = new SystemInfo();

    public String getCPUInfo() {
        CentralProcessor cpu = si.getHardware().getProcessor();
        double freqGHz = cpu.getProcessorIdentifier().getVendorFreq() / 1_000_000_000.0;

        return String.format("CPU: %s\nNúcleos físicos: %d\nHilos (Núcleos lógicos): %d\nFrecuencia base: %.2f GHz\nMicroarquitectura: %s",
            cpu.getProcessorIdentifier().getName(),
            cpu.getPhysicalProcessorCount(),
            cpu.getLogicalProcessorCount(), 
            freqGHz,
            cpu.getProcessorIdentifier().getMicroarchitecture());
    }

    public String getRAMInfo() {
        GlobalMemory mem = si.getHardware().getMemory();
        return String.format("RAM total: %.2f GB", mem.getTotal() / 1e9);
    }

    public String getMotherboardInfo() {
        ComputerSystem cs = si.getHardware().getComputerSystem();
        return String.format("Placa madre: %s %s", cs.getManufacturer(), cs.getModel());
    }

    public String getGPUInfo() {
        List<GraphicsCard> gpus = si.getHardware().getGraphicsCards();
        
        GraphicsCard gpu = !gpus.isEmpty() ? gpus.get(0) : null;
        
        double vramGB = gpu != null ? gpu.getVRam() / 1_073_741_824.0 : 0;
        
        return gpu != null
            ? String.format("GPU: %s\nMemoria (VRAM): %.2f GB", gpu.getName(), vramGB) 
            : "GPU no detectada.";
    }
}