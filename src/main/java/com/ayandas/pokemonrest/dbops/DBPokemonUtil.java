package com.ayandas.pokemonrest.dbops;

import com.ayandas.pokemonrest.models.Pokemon;
import com.ayandas.pokemonrest.models.Matchup;
import com.ayandas.pokemonrest.models.Review;

import com.ayandas.pokemonrest.extrapojo.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

public class DBPokemonUtil {
  public static Pokemon getPokemon(int id) {
      Pokemon p = null;
      try {
          SessionFactory factory = new Configuration().configure()
              .buildSessionFactory();
          Session session = factory.openSession();
          Transaction tx = session.beginTransaction();
          p = (Pokemon) session.createCriteria(Pokemon.class)
              .add(Restrictions.eq("id", id))
              .uniqueResult();
          //return p;
          tx.commit();
          session.close();
          factory.close();
      } catch (Exception e) {
          e.printStackTrace();
          //System.exit(0);
      } finally {
          return p;
      }
  }

  public static List<Pokemon> getStrongerOpponents(int id) {
      ArrayList<Pokemon> results = new ArrayList<>();
      try {
          Pokemon p = getPokemon(id);
          List<Matchup> matchups = new ArrayList<>();
          if (p.getType2().equals("")) {
              matchups = getWeaknesses(p.getType1());
          } else {
              matchups = getWeaknesses(p.getType1(), p.getType2());
          }
          for (Matchup m: matchups) {
              SessionFactory factory = new Configuration().configure()
                  .buildSessionFactory();
              Session session = factory.openSession();
              Transaction tx = session.beginTransaction();
              List strongerPokemon = session.createCriteria(Pokemon.class)
                  .add(Restrictions.or(Restrictions.eq("type1", m.getAttackType()), Restrictions.eq("type2", m.getAttackType())))
                  .list();
              for (Object o: strongerPokemon) {
                  Pokemon aPokemon = (Pokemon) o;
                  results.add(aPokemon);
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          return results;
      }
  }

  public static List<Pokemon> getPokemonFormes(int id) {
      List p = null;
      ArrayList<Pokemon> pokemon = new ArrayList<>();
      try {
          SessionFactory factory = new Configuration().configure()
              .buildSessionFactory();
          Session session = factory.openSession();
          Transaction tx = session.beginTransaction();
          p = session.createCriteria(Pokemon.class)
                  .add(Restrictions.eq("ndex", id))
                  .list();
          for (Object o: p) {
              Pokemon a = (Pokemon) o;
              pokemon.add(a);
          }
          //return p;
          tx.commit();
          session.close();
          factory.close();
      } catch (Exception e) {
          e.printStackTrace();
          //System.exit(0);
      } finally {
          return pokemon;
      }
  }

  public static List<Pokemon> allPokemon() {
      List p  = null;
      ArrayList<Pokemon> pokemon = new ArrayList<>();
      try {
        SessionFactory factory = new Configuration().configure()
            .buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        p = session.createCriteria(Pokemon.class)
                .list();
        for (Object o: p) {
            Pokemon a = (Pokemon) o;
            pokemon.add(a);
        }
        //return p;
        tx.commit();
        session.close();
        factory.close();
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          return pokemon;
      }
  }

  public static List<Matchup> getWeaknesses(String ... types) {
      ArrayList<String> defendingTypes = new ArrayList<>();
      for (String type: types) {
          defendingTypes.add(type);
      }
      List<Matchup> result = new ArrayList<>();
      try {
          SessionFactory factory = new Configuration().configure()
              .buildSessionFactory();
          Session session = factory.openSession();
          Transaction tx = session.beginTransaction();
          Criteria c = session.createCriteria(Matchup.class);
          c = c.add(Restrictions.eq("defenseType1", defendingTypes.get(0)));
          if (defendingTypes.size() == 2) {
              c = c.add(Restrictions.eq("defenseType2", defendingTypes.get(1)));
          } else {
              c = c.add(Restrictions.eq("defenseType2", ""));
          }
          c = c.add(Restrictions.gt("effect", 1.0));
          List l = c.list();
          for (Object m: l) {
              Matchup mu = (Matchup) m;
              result.add(mu);
          }
          //result = (List<Matchup>) c.list();
          //return p;
          tx.commit();
          session.close();
          factory.close();
      } catch (Exception e) {
          e.printStackTrace();
          //System.exit(0);
      } finally {
          return result;
      }
  }

  private static HashMap<String, Type> getAbilityChanges() {
      HashMap<String, Type> abilityMap = new HashMap<>();
      abilityMap.put("Dry Skin", new Type("fire", 1.25));
      abilityMap.put("Heatproof", new Type("fire", 0.5));
      abilityMap.put("Flash Fire", new Type("fire", 0));
      abilityMap.put("Levitate", new Type("ground", 0));
      abilityMap.put("Lightning Rod", new Type("electric", 0));
      abilityMap.put("Motor Drive", new Type("electric", 0));
      abilityMap.put("Sap Sipper", new Type("grass", 0));
      abilityMap.put("Storm Drain", new Type("water", 0));
      abilityMap.put("Thick Fat-1", new Type("fire", 0.5));
      abilityMap.put("Thick Fat-2", new Type("ice", 0.5));
      abilityMap.put("Volt Absorb", new Type("electric", 0));
      abilityMap.put("Water Absorb", new Type("water", 0));
      abilityMap.put("Water Bubble", new Type("fire", 0.5));
      return abilityMap;
  }
}
