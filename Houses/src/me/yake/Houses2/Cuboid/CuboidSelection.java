package me.yake.Houses2.Cuboid;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class CuboidSelection  {
    protected static Location highPoints;
    protected static Location lowPoints;
    
    public CuboidSelection()
    {
        
    }

    public static void CuboidArea(Location startLoc, Location endLoc, Player player) {
        int highx, highy, highz, lowx, lowy, lowz;
        if (startLoc.getBlockX() > endLoc.getBlockX()) {
            highx = startLoc.getBlockX();
            lowx = endLoc.getBlockX();
        } else {
            highx = endLoc.getBlockX();
            lowx = startLoc.getBlockX();
        }
        if (startLoc.getBlockY() > endLoc.getBlockY()) {
            highy = startLoc.getBlockY();
            lowy = endLoc.getBlockY();
        } else {
            highy = endLoc.getBlockY();
            lowy = startLoc.getBlockY();
        }
        if (startLoc.getBlockZ() > endLoc.getBlockZ()) {
            highz = startLoc.getBlockZ();
            lowz = endLoc.getBlockZ();
        } else {
            highz = endLoc.getBlockZ();
            lowz = startLoc.getBlockZ();
        }
        highPoints = new Location(startLoc.getWorld(),highx,highy,highz);
        lowPoints = new Location(startLoc.getWorld(),lowx,lowy,lowz);
    }
    public static long getSize()
    {
        int xsize = (highPoints.getBlockX() - lowPoints.getBlockX())+1;
        int ysize = (highPoints.getBlockY() - lowPoints.getBlockY())+1;
        int zsize = (highPoints.getBlockZ() - lowPoints.getBlockZ())+1;
        return xsize * ysize * zsize;
    }

    public static int getXSize()
    {
        return (highPoints.getBlockX() - lowPoints.getBlockX())+1;
    }

    public static int getYSize()
    {
        return (highPoints.getBlockY() - lowPoints.getBlockY())+1;
    }

    public static int getZSize()
    {
        return (highPoints.getBlockZ() - lowPoints.getBlockZ())+1;
    }

    public Location getHighLoc()
    {
        return highPoints;
    }

    public Location getLowLoc()
    {
        return lowPoints;
    }

    public World getWorld()
    {
        return highPoints.getWorld();
    }

}

