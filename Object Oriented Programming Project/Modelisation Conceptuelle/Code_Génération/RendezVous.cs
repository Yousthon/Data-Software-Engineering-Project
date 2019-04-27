// File:    RendezVous.cs
// Author:  kouassi
// Created: vendredi 13 juillet 2018 20:14:58
// Purpose: Definition of Class RendezVous

using System;

public class RendezVous
{
   private String rendezvousID;
   private String rendezvousDate;
   
   public System.Collections.ArrayList prestation;
   
   /// <summary>
   /// Property for collection of Prestation
   /// </summary>
   /// <pdGenerated>Default opposite class collection property</pdGenerated>
   public System.Collections.ArrayList Prestation
   {
      get
      {
         if (prestation == null)
            prestation = new System.Collections.ArrayList();
         return prestation;
      }
      set
      {
         RemoveAllPrestation();
         if (value != null)
         {
            foreach (Prestation oPrestation in value)
               AddPrestation(oPrestation);
         }
      }
   }
   
   /// <summary>
   /// Add a new Prestation in the collection
   /// </summary>
   /// <pdGenerated>Default Add</pdGenerated>
   public void AddPrestation(Prestation newPrestation)
   {
      if (newPrestation == null)
         return;
      if (this.prestation == null)
         this.prestation = new System.Collections.ArrayList();
      if (!this.prestation.Contains(newPrestation))
         this.prestation.Add(newPrestation);
   }
   
   /// <summary>
   /// Remove an existing Prestation from the collection
   /// </summary>
   /// <pdGenerated>Default Remove</pdGenerated>
   public void RemovePrestation(Prestation oldPrestation)
   {
      if (oldPrestation == null)
         return;
      if (this.prestation != null)
         if (this.prestation.Contains(oldPrestation))
            this.prestation.Remove(oldPrestation);
   }
   
   /// <summary>
   /// Remove all instances of Prestation from the collection
   /// </summary>
   /// <pdGenerated>Default removeAll</pdGenerated>
   public void RemoveAllPrestation()
   {
      if (prestation != null)
         prestation.Clear();
   }

}