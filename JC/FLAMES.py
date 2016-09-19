SPACE = " "

# stub
# def all_same(name_1, name_2):
#   """ (str, str) -> int
#   Returns the length of the same letters of the two names
#   """
#   return 0

# template
# def all_same(name_1, name_2):
#   """ (str, str) -> int
#   Returns the length of the same letters of the two names
#   """
#   for i in name_1:
#       ...
#   for l in name_2:
#       ...
#   return ...

def all_same(name_1, name_2):
    """ (str, str) -> int
    Returns the length of the same letters of the two names
    """
    count = 0
    lower_1 = name_1.lower()
    lower_2 = name_2.lower()
    for i in lower_1:
        for l in lower_2:
            if (i == l and l != SPACE and i != SPACE):
                count = count + 1
                break;
    for l in lower_2:
        for i in lower_1:
            if (l == i and i != SPACE and l != SPACE):
                count = count + 1
                break;
    return count

"test for no same"
all_same("Daniel", "Jynx") # expect 2
all_same("David Jabbs", "Jynx Ward") # expect 8
all_same("", "") # expect 0

# stub
# def difference(name_1, name_2):
#   """(str, str) -> int
#   Returns the difference of the length of all names and function all_same
#   """
#   return 0

# template
# def difference(name_1, name_2):
#   """(str, str) -> int
#   Returns the difference of the length of all names and function all_same
#   """
#   for ch in name_1:
#       ...
#   for char in name_2:
#       ...
#   return ...

def difference(name_1, name_2):
    """(str, str) -> int
    Returns the difference of the length of all names and function all_same
    """
    count = 0
    for ch in name_1:
        if (ch != SPACE):
            count = count + 1
    for char in name_2:
        if (char != SPACE):
            count = count + 1
    return count - all_same(name_1, name_2)

"test for difference"
difference("Daniel", "Jynx") # expect 8
difference("David Jabbs", "Jynx Ward") # expect 10
difference("", "") # expect 0

# stub
# def fortune(x, y):
#     """ (str, str) -> str
#     Returns the FLAMES fortune of those two people
#     """
#     return ""

# template
# def fortune(x, y):
#     """ (str, str) -> str
#     Returns the FLAMES fortune of those two people
#     """
#     	return ...


def fortune(name_1, name_2):
    """ (str, str) -> str
    Returns the FLAMES fortune of two people
    """
    if (difference(name_1, name_2) % 6 == 0):
    	return "The Fortune of " + name_1 + " and " + name_2 + " are SOULMATE"
    elif (difference(name_1, name_2) % 6 == 1):
    	return "The Fortune of " + name_1 + " and " + name_2 + " are FRIENDSHIP"
    elif (difference(name_1, name_2) % 6 == 2):
    	return "The Fortune of " + name_1 + " and " + name_2 + " are LOVE"
    elif (difference(name_1, name_2) % 6 == 3):
    	return "The Fortune of " + name_1 + " and " + name_2 + " are ADMIRATION"
    elif (difference(name_1, name_2) % 6 == 4):
    	return "The Fortune of " + name_1 + " and " + name_2 + " are MARRIAGE"
    else:
    	return "The Fortune of " + name_1 + " and " + name_2 + " are ENEMIES"


# print("test for fortune")
# print(fortune("Daniel Jabbs", "Jinna Ward")) # expect Friendship
# print(fortune("Stephen Jones", "Pia Bryant")) # expect Love
# print(fortune("Seth James", "Riley King")) # expect Admiration
# print(fortune("David Jabbs", "Jynx Ward")) # expect Marriage
# print(fortune("Chris Young", "Hanna Forde")) # expect Enemies
print(fortune("John Caesar Patac", "Edin Bernice Adolfo")) # expect Soulmate
