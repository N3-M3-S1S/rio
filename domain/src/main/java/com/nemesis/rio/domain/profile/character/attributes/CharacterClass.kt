package com.nemesis.rio.domain.profile.character.attributes

enum class CharacterClass(vararg val specs: Spec) {
    DEATH_KNIGHT(Spec.BLOOD, Spec.FROST_DEATH_KNIGHT, Spec.UNHOLY),
    DEMON_HUNTER(Spec.HAVOC, Spec.VENGEANCE),
    DRUID(Spec.BALANCE, Spec.FERAL, Spec.GUARDIAN, Spec.RESTORATION_DRUID),
    HUNTER(Spec.BEAST_MASTERY, Spec.MARKSMANSHIP, Spec.SURVIVAL),
    MAGE(Spec.ARCANE, Spec.FIRE, Spec.FROST_MAGE),
    MONK(Spec.BREWMASTER, Spec.MISTWEAVER, Spec.WINDWALKER),
    PALADIN(Spec.HOLY_PALADIN, Spec.PROTECTION_PALADIN, Spec.RETRIBUTION),
    PRIEST(Spec.DISCIPLINE, Spec.HOLY_PRIEST, Spec.SHADOW),
    ROGUE(Spec.ASSASSINATION, Spec.OUTLAW, Spec.SUBTLETY),
    SHAMAN(Spec.ELEMENTAL, Spec.ENHANCEMENT, Spec.RESTORATION_SHAMAN),
    WARLOCK(Spec.AFFLICTION, Spec.DEMONOLOGY, Spec.DESTRUCTION),
    WARRIOR(Spec.ARMS, Spec.FURY, Spec.PROTECTION_WARRIOR);

    val roles = specs.mapTo(mutableSetOf(), Spec::role)
}
