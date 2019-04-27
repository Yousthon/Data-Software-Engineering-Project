// File:    Patient.cs
// Author:  kouassi
// Created: vendredi 13 juillet 2018 20:15:00
// Purpose: Definition of Class Patient

using System;

public class Patient
{
   private String patientID;
   private String patientNom;
   private String patientPrenom;
   private String patientTel;
   private String patientEmail;
   private String patientAdresse;
   
   public TypePatient typePatient;
   public System.Collections.ArrayList rendezVous;
   
   /// <summary>
   /// Property for collection of RendezVous
   /// </summary>
   /// <pdGenerated>Default opposite class collection property</pdGenerated>
   public System.Collections.ArrayList RendezVous
   {
      get
      {
         if (rendezVous == null)
            rendezVous = new System.Collections.ArrayList();
         return rendezVous;
      }
      set
      {
         RemoveAllRendezVous();
         if (value != null)
         {
            foreach (RendezVous oRendezVous in value)
               AddRendezVous(oRendezVous);
         }
      }
   }
   
   /// <summary>
   /// Add a new RendezVous in the collection
   /// </summary>
   /// <pdGenerated>Default Add</pdGenerated>
   public void AddRendezVous(RendezVous newRendezVous)
   {
      if (newRendezVous == null)
         return;
      if (this.rendezVous == null)
         this.rendezVous = new System.Collections.ArrayList();
      if (!this.rendezVous.Contains(newRendezVous))
         this.rendezVous.Add(newRendezVous);
   }
   
   /// <summary>
   /// Remove an existing RendezVous from the collection
   /// </summary>
   /// <pdGenerated>Default Remove</pdGenerated>
   public void RemoveRendezVous(RendezVous oldRendezVous)
   {
      if (oldRendezVous == null)
         return;
      if (this.rendezVous != null)
         if (this.rendezVous.Contains(oldRendezVous))
            this.rendezVous.Remove(oldRendezVous);
   }
   
   /// <summary>
   /// Remove all instances of RendezVous from the collection
   /// </summary>
   /// <pdGenerated>Default removeAll</pdGenerated>
   public void RemoveAllRendezVous()
   {
      if (rendezVous != null)
         rendezVous.Clear();
   }

}