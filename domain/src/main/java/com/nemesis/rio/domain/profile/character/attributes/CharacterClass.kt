package com.nemesis.rio.domain.profile.character.attributes

enum class CharacterClass(vararg val specs: Spec) {
    DEATH_KNIGHT(Spec.FROST_DEATH_KNIGHT, Spec.BLOOD, Spec.UNHOLY),
    DEMON_HUNTER(Spec.HAVOC, Spec.VENGEANCE),
    DRUID(Spec.GUARDIAN, Spec.RESTORATION_DRUID, Spec.FERAL, Spec.BALANCE),
    HUNTER(Spec.MARKSMANSHIP, Spec.BEAST_MASTERY, Spec.SURVIVAL),
    MAGE(Spec.FROST_MAGE, Spec.FIRE, Spec.ARCANE),
    MONK(Spec.BREWMASTER, Spec.MISTWEAVER, Spec.WINDWALKER),
    PALADIN(Spec.PROTECTION_PALADIN, Spec.HOLY_PALADIN, Spec.RETRIBUTION),
    PRIEST(Spec.HOLY_PRIEST, Spec.DISCIPLINE, Spec.SHADOW),
    ROGUE(Spec.ASSASSINATION, Spec.SUBTLETY, Spec.OUTLAW),
    SHAMAN(Spec.RESTORATION_SHAMAN, Spec.ELEMENTAL, Spec.ENHANCEMENT),
    WARLOCK(Spec.AFFLICTION, Spec.DESTRUCTION, Spec.DEMONOLOGY),
    WARRIOR(Spec.PROTECTION_WARRIOR, Spec.FURY, Spec.ARMS);
}